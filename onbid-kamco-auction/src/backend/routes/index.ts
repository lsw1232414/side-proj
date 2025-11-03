import { Router } from 'express';
import BidController from '../controllers/bidController';
import FavoriteController from '../controllers/favoriteController';

const router = Router();
const bidController = new BidController();
const favoriteController = new FavoriteController();

export function setRoutes(app) {
    // Bid routes
    app.get('/api/bids', bidController.getBids.bind(bidController));
    app.get('/api/bids/:id', bidController.getBidDetails.bind(bidController));

    // Favorite routes
    app.post('/api/favorites', favoriteController.addFavorite.bind(favoriteController));
    app.delete('/api/favorites/:id', favoriteController.removeFavorite.bind(favoriteController));
}