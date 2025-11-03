export type Bid = {
    id: string;
    title: string;
    description: string;
    startingPrice: number;
    currentPrice: number;
    endDate: Date;
    isFavorite: boolean;
};

export type FavoriteBid = {
    userId: string;
    bidId: string;
};

export type ApiResponse<T> = {
    success: boolean;
    data: T;
    message?: string;
};

export type BidListResponse = ApiResponse<Bid[]>;

export type BidDetailResponse = ApiResponse<Bid>;