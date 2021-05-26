import { Component, OnInit } from '@angular/core';
import {CarService} from '../../services/car.service';
import {ActivatedRoute} from '@angular/router';
import {Car} from '../../models/car';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent implements OnInit {
  car: Car;

  constructor(private carService: CarService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getCarDetail();
  }

  getCarDetail(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.carService.getCarById(id).subscribe(car => this.car = car);
  }


}
