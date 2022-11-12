import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';


@Component({
  selector: 'app-employee',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public employees : Employee[] = [];

  constructor(private employeeService : EmployeeService){}

  ngOnInit(){
    this.getEmployeess();
  }

  public getEmployeess(): void {
    this.employeeService.getEmployees().subscribe(
      (responce : Employee[]) =>{
        this.employees = responce;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );  
  }

  public onOpenmodel (employee : Employee, mode : String):void{
    const container = document.getElementById('main-container')!;
    const button = document.createElement('button');
    button.type = "button";
    button.style.display = 'none';
    button.setAttribute('data-toggel','model');
    if( mode === 'add'){
      button.setAttribute('data-target','#addEmployeeModal');
    }
    if( mode === 'edit'){
      button.setAttribute('data-target','#editEmployeeModal');
    }
    if( mode == 'delet'){
      button.setAttribute('data-target','#deleteEmployeeModal');
    }

    container.appendChild(button);
    button.click();
  }
}
