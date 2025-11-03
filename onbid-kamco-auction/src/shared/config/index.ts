export const config = {
    apiBaseUrl: process.env.API_BASE_URL || 'http://localhost:3000/api',
    auctionApiUrl: process.env.AUCTION_API_URL || 'https://api.example.com/auctions',
    defaultPageSize: 10,
    maxFavorites: 100,
};