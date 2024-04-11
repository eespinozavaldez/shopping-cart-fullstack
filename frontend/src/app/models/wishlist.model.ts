import { Product } from "./product.model";
import { User } from "./user.model";

export interface WishList {
    wishId : number;
    user: User;
    product: Product;
}