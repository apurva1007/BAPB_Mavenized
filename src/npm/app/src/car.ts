
export class Car{

    carId: number;
    make: string = "";
    model: string = "";
    yearOfBuying: string = "";
    distanceTravelled: number;
    baseSellingPrice: number;
    entryDate: string = "";

    constructor(make: string, model: string, yearOfBuying: string, distanceTravelled: number, baseSellingPrice: number) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
    }
}