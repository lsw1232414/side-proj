export interface Bid {
    id: string;
    title: string;
    description: string;
    startingPrice: number;
    currentPrice: number;
    endDate: Date;
    isFavorite: boolean;
}

export interface Favorite {
    userId: string;
    bidId: string;
}

export interface BidDetail extends Bid {
    bidHistory: Array<{
        userId: string;
        bidAmount: number;
        timestamp: Date;
    }>;
}

export interface ApiResponse<T> {
    success: boolean;
    data: T;
    message?: string;
}