
export class Car{

    carId: number;
    make: string = "";
    model: string = "";
    yearOfBuying: number;
    distanceTravelled: number;
    baseSellingPrice: number;
    entryDate: Date;

    constructor(make: string, model: string, yearOfBuying: number, distanceTravelled: number, baseSellingPrice: number) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
    }
}