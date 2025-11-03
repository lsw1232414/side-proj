import { CronJob } from 'cron';
import { PublicApiService } from '../services/publicApiService';
import { BidService } from '../services/bidService';

const publicApiService = new PublicApiService();
const bidService = new BidService();

const syncPublicApiJob = new CronJob('0 * * * *', async () => {
    try {
        const auctionData = await publicApiService.fetchAuctionData();
        await bidService.syncBids(auctionData);
        console.log('Successfully synced public API data.');
    } catch (error) {
        console.error('Error syncing public API data:', error);
    }
});

export default syncPublicApiJob;