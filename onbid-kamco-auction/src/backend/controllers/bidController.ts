class BidController {
    constructor(bidService) {
        this.bidService = bidService;
    }

    async getBidList(req, res) {
        try {
            const bids = await this.bidService.fetchBidList();
            res.status(200).json(bids);
        } catch (error) {
            res.status(500).json({ message: 'Error fetching bid list', error });
        }
    }

    async getBidDetails(req, res) {
        const { id } = req.params;
        try {
            const bidDetails = await this.bidService.fetchBidDetails(id);
            if (!bidDetails) {
                return res.status(404).json({ message: 'Bid not found' });
            }
            res.status(200).json(bidDetails);
        } catch (error) {
            res.status(500).json({ message: 'Error fetching bid details', error });
        }
    }
}

export default BidController;