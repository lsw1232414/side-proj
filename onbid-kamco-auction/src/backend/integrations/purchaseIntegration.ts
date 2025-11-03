export class PurchaseIntegration {
    private purchaseApiUrl: string;

    constructor() {
        this.purchaseApiUrl = process.env.PURCHASE_API_URL || 'http://localhost:3000/api/purchase';
    }

    public async initiatePurchase(bidId: string, userId: string): Promise<any> {
        try {
            const response = await fetch(`${this.purchaseApiUrl}/initiate`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ bidId, userId }),
            });

            if (!response.ok) {
                throw new Error('Failed to initiate purchase');
            }

            return await response.json();
        } catch (error) {
            console.error('Error initiating purchase:', error);
            throw error;
        }
    }

    public async confirmPurchase(purchaseId: string): Promise<any> {
        try {
            const response = await fetch(`${this.purchaseApiUrl}/confirm`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ purchaseId }),
            });

            if (!response.ok) {
                throw new Error('Failed to confirm purchase');
            }

            return await response.json();
        } catch (error) {
            console.error('Error confirming purchase:', error);
            throw error;
        }
    }

    public async cancelPurchase(purchaseId: string): Promise<any> {
        try {
            const response = await fetch(`${this.purchaseApiUrl}/cancel`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ purchaseId }),
            });

            if (!response.ok) {
                throw new Error('Failed to cancel purchase');
            }

            return await response.json();
        } catch (error) {
            console.error('Error canceling purchase:', error);
            throw error;
        }
    }
}