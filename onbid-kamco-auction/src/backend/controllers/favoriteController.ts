export class FavoriteController {
    private favoriteService: FavoriteService;

    constructor(favoriteService: FavoriteService) {
        this.favoriteService = favoriteService;
    }

    public async addFavorite(req: Request, res: Response): Promise<void> {
        try {
            const { bidId } = req.body;
            const userId = req.user.id; // Assuming user ID is available in the request
            await this.favoriteService.addFavorite(userId, bidId);
            res.status(201).json({ message: 'Bid added to favorites' });
        } catch (error) {
            res.status(500).json({ message: 'Error adding favorite', error });
        }
    }

    public async removeFavorite(req: Request, res: Response): Promise<void> {
        try {
            const { bidId } = req.params;
            const userId = req.user.id; // Assuming user ID is available in the request
            await this.favoriteService.removeFavorite(userId, bidId);
            res.status(200).json({ message: 'Bid removed from favorites' });
        } catch (error) {
            res.status(500).json({ message: 'Error removing favorite', error });
        }
    }

    public async getFavorites(req: Request, res: Response): Promise<void> {
        try {
            const userId = req.user.id; // Assuming user ID is available in the request
            const favorites = await this.favoriteService.getFavorites(userId);
            res.status(200).json(favorites);
        } catch (error) {
            res.status(500).json({ message: 'Error retrieving favorites', error });
        }
    }
}