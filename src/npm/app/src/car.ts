
export class Car{

    carId: number;
    make: string = "";
    model: string = "";
    yearOfBuying: number;
    distanceTravelled: number;
    baseSellingPrice: number;
    entryDate:Date;
    available: boolean;
    biddingPeriod:number;

    constructor(make: string, model: string, yearOfBuying: number, distanceTravelled: number, baseSellingPrice: number,entryDate:Date, available:boolean, biddingPeriod:number) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.entryDate = entryDate;
        this.available = available;
        this.biddingPeriod =biddingPeriod;
    }
}