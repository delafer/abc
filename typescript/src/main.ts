import Kefir from 'kefir';
import { Callback, LoadJson } from "./LoadJson";
import { Entry } from "./Entry";

alert('code executed 2');

let obj: Entry[] = [];
let searchBox: HTMLInputElement = <HTMLInputElement>document.getElementById("searchBox");
let last = '';

LoadJson.createCORSRequest({
    onSuccess(result: string): void {
        console.log(`success: ${result}`);
        obj = JSON.parse(result);
    },
    onError(result: string): void {
        console.log(`error: ${result}`);
    }
} as Callback);

let inputValue = Kefir
    .fromEvents(searchBox, 'keyup')
    .debounce(750)
    .filter(_ => {
        return searchBox.value.length > 1 && last !== searchBox.value;
    })
    .map(_ => obj.filter((e: {
        title: string ;
    }) => (e.title.toLowerCase().indexOf(searchBox.value.toLowerCase()) !== -1)));


function createTD(fragment: DocumentFragment):any {
    let td:any = document.createElement('td');
    td.setAttribute("valign", "TOP");
    td.setAttribute("width", "159");
    fragment.appendChild(td);
    return td;
}

inputValue.onValue((res:Entry[]) => {
    last = searchBox.value;
    console.log('HAHAHA');
    document.getElementById("contents").hidden = (res.length > 0);

    let fragment = document.createDocumentFragment();

    let chunk = Math.ceil(res.length / 3);
    if (chunk < 7) chunk = 7;

    removeElement("dyntbl");
    addElement("mainContent",s);

    let lastCh: string;
    let paragraph:any;
    let td: any;
    let lastRow: number = 0;
    res.forEach((item: Entry, index: number) => {
        let hyperlink = document.createElement('a');

        let linkText = document.createTextNode(item.title);

        let row =  Math.floor(index  / chunk) + 1;

        if (row > lastRow) {
            td = createTD(fragment);
            lastRow = row;
            lastCh = '';
        }


        let newCh = item.title.charAt(0);
        if (lastCh !== newCh) {
            lastCh = newCh;

            paragraph = document.createElement('p');
            paragraph.setAttribute("class", "bk");
            paragraph.classList.add('bk');
            paragraph.innerText = newCh;

            td.appendChild(paragraph);

            paragraph = document.createElement('p');
            paragraph.setAttribute('style', 'margin-bottom: 0px'); //pe.style = 'margin-bottom: 0px';
            paragraph.setAttribute("class", "ls");
            paragraph.classList.add('ls');
            td.appendChild(paragraph);
        }

        hyperlink.appendChild(linkText);
        hyperlink.title = item.title;
        hyperlink.href = item.url;
        paragraph.appendChild(hyperlink);
        paragraph.appendChild(document.createElement("br"));
    });

    for (let i = lastRow; i < 3; i++) {
        createTD(fragment);
    }


    document.getElementById("row1").appendChild(fragment);

    hideEvents.forEach(function (event) {
        button.addEventListener(event, hide);


    });



function addElement(parentId:string, html: string) {
// Adds an element to the document
    let p = document.getElementById(parentId).insertAdjacentHTML("afterbegin", html);
}



function removeElement(elementId: string) {
    // Removes an element from the document
    let element = document.getElementById(elementId);
    if (element && element.parentNode) {
        element.parentNode.removeChild(element);
    }

}

const s : string = '<table border="0" width="478" cellspacing="0" cellpadding="0" id="dyntbl">\n' +
    '   <tbody>\n' +
    '      <tr id="row1">\n' +
    '      </tr>\n' +
    '      <tr>\n' +
    '         <td valign="TOP" width="476" align="center" colspan="3">\n' +
    '         </td>\n' +
    '      </tr>\n' +
    '   </tbody>\n' +
    '</table>';
