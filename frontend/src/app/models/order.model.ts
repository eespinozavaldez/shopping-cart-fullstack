import { Product } from "./product.model";
import { User } from "./user.model";

export interface Order {
   orderId: number;
   orderDate: Date;
   user: User;
   product: Product;

}