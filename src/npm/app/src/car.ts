
export class Car{

    carId: number;
    make: string = "";
    model: string = "";
    yearOfBuying: number;
    distanceTravelled: number;
    baseSellingPrice: number;
    entryDate: Date;
    available: boolean;

    constructor(make: string, model: string, yearOfBuying: number, distanceTravelled: number, baseSellingPrice: number, available:boolean) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.available = this.available;
    }
}