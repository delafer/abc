
export interface Callback {
    onSuccess(result:string):void;
    onError(msg:string):void;
}

export class LoadJson {

static createCORSRequest(callback: Callback) {
    let method : string = 'GET';
    let url: string = 'http://www.abc-guitars.com/json/search-list.json';
    if(XMLHttpRequest) {
        let xobj: XMLHttpRequest = new XMLHttpRequest();
        xobj.overrideMimeType("application/json");
        xobj.open(method, url, true);
        xobj.setRequestHeader('Content-Type', 'application/json');

        if ('withCredentials' in xobj) {
            xobj.withCredentials = true;
            xobj.onload = function() {
                callback.onSuccess(xobj.responseText);
            };
            xobj.onerror = function() {
                callback.onError('There was an error making the request.');
            };
        } else {
            // @ts-ignore
            xobj.onreadystatechange = function () {
                if (xobj.readyState == 4 && xobj.status == 200) {
                    // .open will NOT return a value but simply returns undefined in async mode so use a callback
                    callback.onSuccess(xobj.responseText);
                } else {
                    callback.onError(`There was an error making the request. (${xobj.status})`);
                }
            }
        }
        xobj.send();
    } else
        // @ts-ignore
        if (typeof XDomainRequest != 'undefined') {

                // Otherwise, check if XDomainRequest.
                // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
                // @ts-ignore
                let xhr = new XDomainRequest();
                xhr.open(method, url);

                xhr.onload = function() {
                    callback.onSuccess(xhr.responseText);
                };
                xhr.onerror = function() {
                    callback.onError('There was an error making the request.');
                };
                xhr.send();

            } else {
                //xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                // Otherwise, CORS is not supported by the browser.
                callback.onError('CORS is not supported by the browser.');

            }
    }
}
