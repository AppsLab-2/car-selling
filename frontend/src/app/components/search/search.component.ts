import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Car} from '../../models/car';
import {CarService} from '../../services/car.service';
import {Brand} from '../../models/brand';
import {FormControl, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  filterGroup = new FormGroup({
    brand: new FormControl(''),
    maxPrice: new FormControl(''),
    transmission: new FormControl(''),
    type: new FormControl('')
  });

  transmissions = ['Automatic', 'Manual'];
  cars: Observable<Car[]>;
  brands: Brand[];
  types: string[];

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.cars = this.getCars();
    this.carService.getBrands()
      .subscribe(brands => this.brands = brands);
    this.carService.getCarTypes()
      .subscribe(types => this.types = types);
  }

  getCars(): Observable<Car[]> {
    return this.carService.getCars();
  }

  filter(): void {
    if (!this.filterGroup.pristine) {
      this.cars = this.carService.filterCars(this.filterGroup.value);
    }
  }

  cancelFilters(): void {
    this.filterGroup.reset();
    this.cars = this.getCars();
  }


}
