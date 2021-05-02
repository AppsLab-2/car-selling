import { Component, OnInit } from '@angular/core';
import {CarService} from '../../services/car.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent implements OnInit {

  car: any;

  constructor(private carService: CarService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.carService.getCarById(id).subscribe((car: any) => this.car = car);
  }

}
