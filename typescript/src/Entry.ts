export interface Entry {

    title: string;
    text: string;
    type: string;
    surname: string;
    forename: string;
    patronymic: string;
    country: string;

    dates: Dates;
    image: string;
    url: string;

}

export interface Dates {

    born: string;
    died: string;

}
