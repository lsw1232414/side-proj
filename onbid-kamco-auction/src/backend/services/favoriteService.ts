export class FavoriteService {
    private favorites: Set<number>;

    constructor() {
        this.favorites = new Set<number>();
    }

    addFavorite(bidId: number): boolean {
        if (!this.favorites.has(bidId)) {
            this.favorites.add(bidId);
            return true;
        }
        return false;
    }

    removeFavorite(bidId: number): boolean {
        if (this.favorites.has(bidId)) {
            this.favorites.delete(bidId);
            return true;
        }
        return false;
    }

    getFavorites(): number[] {
        return Array.from(this.favorites);
    }

    isFavorite(bidId: number): boolean {
        return this.favorites.has(bidId);
    }
}