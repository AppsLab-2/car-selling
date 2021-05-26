import {Brand} from './brand';
import {Model} from './model';

export interface Car {
  id: number;
  brand: Brand;
  model: Model;
  description: string;
  productionYear: number;
  hp: number;
  fuel: string;
  transmission: string;
  type: string;
  price: number;
  image: string;
}
