import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LabelType, Options} from '@angular-slider/ngx-slider';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  apiUrl = environment.apiUrl;
  cars = [];
  brands = [];
  models = [];

  error = false;

  searchForm: FormGroup;

  minValue = 10000;
  maxValue = 50000;
  options: Options = {
    floor: 0,
    ceil: 200000,
  };

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.searchForm = this.fb.group({
      minPrice: [],
      maxPrice: [],
      minHp: [],
      maxHp: [],
      minRegistrationYear: [],
      maxRegistrationYear: [],
      fuel: [],
      type: [],
      transmission: [],
      brand: [],
      model: []
    });
    this.searchForm.get('brand').valueChanges.subscribe(value => {
      this.loadModels(value);
    });
  }

  // tslint:disable-next-line:typedef
  search() {
    this.http.post(this.apiUrl + 'cars/search', this.searchForm.value).subscribe((resp: any) => {
      this.cars = resp;
    }, error => {
      console.log(error);
      this.error = true;
    });
  }


  ngOnInit(): void {
    this.getCars();
    this.getBrands();
  }

  getCars() {
    this.http.get(this.apiUrl + 'cars').subscribe((resp: any) => {
      this.cars = resp;
    }, error => {
      console.log(error);
      this.error = true;
    });
  }

  getBrands() {

    this.http.get(this.apiUrl + 'brands').subscribe((resp: any) => {
      this.brands = resp;
    }, error => {
      console.log(error);
      this.error = true;
    });
  }

  loadModels(brand) {
    if(brand) {
      this.http.get(this.apiUrl + 'brands/' + brand.name + '/models').subscribe((resp: any) => {
        this.models = resp;
      }, error => {
        console.log(error);
        this.error = true;
      });
    }
  }


}
