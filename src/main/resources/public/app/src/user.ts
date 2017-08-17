export class User{
    uid:number;
    name:string = "";
    phone:string = "";

    constructor(name: string, phone:string){
        this.name = name;
        this.phone = phone;
    }
}