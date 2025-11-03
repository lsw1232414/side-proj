export class PublicApiService {
    private apiUrl: string;

    constructor() {
        this.apiUrl = 'https://api.example.com/auctions'; // Replace with the actual public API URL
    }

    async fetchAuctionData(): Promise<any> {
        try {
            const response = await fetch(this.apiUrl);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error fetching auction data:', error);
            throw error;
        }
    }

    async fetchAuctionDetails(auctionId: string): Promise<any> {
        try {
            const response = await fetch(`${this.apiUrl}/${auctionId}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error fetching auction details:', error);
            throw error;
        }
    }
}