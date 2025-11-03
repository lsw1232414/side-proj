import { BidService } from '../../src/backend/services/bidService';
import { BidRepository } from '../../src/backend/repositories/bidRepository';

describe('BidService', () => {
    let bidService: BidService;
    let bidRepository: BidRepository;

    beforeEach(() => {
        bidRepository = new BidRepository();
        bidService = new BidService(bidRepository);
    });

    describe('getBids', () => {
        it('should return a list of bids', async () => {
            const bids = await bidService.getBids();
            expect(bids).toBeDefined();
            expect(Array.isArray(bids)).toBe(true);
        });
    });

    describe('getBidDetails', () => {
        it('should return details of a specific bid', async () => {
            const bidId = '1';
            const bidDetails = await bidService.getBidDetails(bidId);
            expect(bidDetails).toBeDefined();
            expect(bidDetails.id).toBe(bidId);
        });
    });

    // Additional tests can be added here for other methods in BidService
});