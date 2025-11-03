export interface Bid {
    id: string;
    title: string;
    description: string;
    startingPrice: number;
    currentPrice: number;
    bidEndTime: Date;
    createdAt: Date;
    updatedAt: Date;
}

export class BidModel {
    constructor(
        public id: string,
        public title: string,
        public description: string,
        public startingPrice: number,
        public currentPrice: number,
        public bidEndTime: Date,
        public createdAt: Date,
        public updatedAt: Date
    ) {}

    static fromJson(json: any): BidModel {
        return new BidModel(
            json.id,
            json.title,
            json.description,
            json.startingPrice,
            json.currentPrice,
            new Date(json.bidEndTime),
            new Date(json.createdAt),
            new Date(json.updatedAt)
        );
    }
}