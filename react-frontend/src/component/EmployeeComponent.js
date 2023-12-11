import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state={
            employee:{},
            department:{},
            organization:{}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployee().then((response)=>{
            this.setState({employee: response.data.employee})
            this.setState({department: response.data.department})
            this.setState({organization: response.data.organization})

            console.log(this.state.employee)
            console.log(this.state.department)
            console.log(this.state.organization)
        })
    }
    
    render() {
        return (
            <div class="container mt-5">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                        <h5 class="card-title">View Employee Details</h5>
                        </div>
                        <div class="card-body">
                        <p class="card-text">First Name: {this.state.employee.firstName}</p>
                        <p class="card-text">Last Name: {this.state.employee.lastName}</p>
                        <p class="card-text">Email: {this.state.employee.email}</p>
                        </div>
                    </div>



                    <div class="card mt-5">
                        <div class="card-header">
                        <h5 class="card-title">View Department Details</h5>
                        </div>
                        <div class="card-body">
                        <p class="card-text">Name: {this.state.department.departmentName}</p>
                        <p class="card-text">Details: {this.state.department.departmentDescription}</p>
                        <p class="card-text">Code: {this.state.department.departmentCode}</p>
                        </div>
                    </div>

                    <div class="card mt-5">
                        <div class="card-header">
                        <h5 class="card-title">View Organization Details</h5>
                        </div>
                        <div class="card-body">
                        <p class="card-text">Name: {this.state.organization.organizationName}</p>
                        <p class="card-text">Details: {this.state.organization.organizationDescription}</p>
                        <p class="card-text">Established: {this.state.organization.createDate}</p>
                        </div>
                    </div>

                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;