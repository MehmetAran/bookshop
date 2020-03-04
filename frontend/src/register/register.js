import React, { Component } from 'react'
import "../login/Login.css";

export default class Register extends Component {
    constructor(props){
        super(props);
        this.state = {
            email:"",
            password:"",
            password2:"",
            name:"",
            username :"",
          }
    }
    

    

  changeEmail = (e) =>{
    this.setState({
      email:e.target.value,
    });
  }
  changeName = (e) =>{
    this.setState({
      name:e.target.value,
    });
  }
  changeUsername = (e) =>{
    this.setState({
      username:e.target.value,
    });
  }
  changePassword = (e) =>{
    this.setState({
      password:e.target.value,
    });
  }
  changePassword2 = (e) =>{
    this.setState({
      password2:e.target.value,
    });
  }

    register =(e)=>{
      if(this.state.password !== this.state.password2){
        alert("The two passwords do not match");
        return;
      }
        e.preventDefault();
       fetch('http://localhost:5000/api/auth/signup', {
        method: 'post',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify({
          email: this.state.email,
          password: this.state.password,
          name:this.state.name,
          username:this.state.username,
        })
       }).then(response => response.json())
       .then(
         data =>
         this.registerResult(data)
            
       )
       .catch(error => console.log(error));  
       console.log(this.state.token)
    
    }

    registerResult =(data)=>{
        console.log(data)
        let errors = data['errors'];
        let message = ""; 
        if(data["errors"] != null){
            errors.forEach(error => {
            message += error['defaultMessage'] +"\n";
            });
        }
        if(data['success'] == false)
            message += data['message']
        if(data['success'] == true)
            message += data['message']

        alert(message);
    }
   

    render() {
        return (
            <div>
                <div className=" login-container">
                <center>
                <div className="login-container2">

                <div className="login-form-1">
                    <h3>Register</h3>
                    <div className="form-group">
                            <input type="text" className="form-control" onChange={this.changeName} placeholder="Your Name *"  />
                        </div>
                    <div className="form-group">
                            <input type="text" className="form-control" onChange={this.changeUsername} placeholder="Your Username *"  />
                        </div>
                    <div>
                        <div className="form-group">
                            <input type="email" className="form-control" onChange={this.changeEmail} placeholder="Your Email *"  />
                        </div>
                        <div className="form-group">
                            <input type="password" className="form-control" onChange={this.changePassword} placeholder="Your Password *"  />
                        </div>
                        <div className="form-group">
                            <input type="password" className="form-control" onChange={this.changePassword2} placeholder="Your Password *"  />
                        </div>
                        <div className="form-group">
                            <input type="submit" className="btnSubmit" value="Register" onClick={this.register} />
                        </div>
                        <div className="form-group">
                        </div>
                        </div>
                </div>
            </div>
      
          </center>
          </div>
            </div>

        )
    }
}
