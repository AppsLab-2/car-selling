import { Brand } from './brand';

export interface FilterOptions {
  brand?: Brand;
  transmission?: string;
  maxPrice?: number;
}
