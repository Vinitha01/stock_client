import { Component, OnInit, Input } from '@angular/core';
import { CompanyService } from 'src/app/service/company.service';
import { Company } from 'src/app/models/company';

@Component({
  selector: 'compare-charts',
  templateUrl: './compare-charts.component.html',
  styleUrls: ['./compare-charts.component.css']
})
export class CompareChartsComponent implements OnInit {


  barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  barChartLabels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  barChartType = 'bar';
  barChartLegend = true;
  barChartData = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
  ];

  constructor(private companyService: CompanyService) { }

  ngOnInit() {
  }

}
