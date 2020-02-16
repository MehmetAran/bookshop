import React, { Component } from 'react'
import "./Login.css";
export default class Login extends Component {
  constructor (props) {
    super(props);
    this.state = {
      emailOrUsername:"",
      password:"",
      token:"",
      data : [],
    }
  }

  changeEmailOrUsername = (e) =>{
    this.setState({
      emailOrUsername:e.target.value,
    });
  }
changePassword = (e) =>{
  this.setState({
    password:e.target.value,
  });
}

  login =(e)=>{

   
    e.preventDefault();
   fetch('http://localhost:5000/api/auth/signin', {
    method: 'post',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({
      usernameOrEmail: this.state.emailOrUsername,
      password: this.state.password,
    })
   }).then(response => response.json())
   .then(  data =>this.setState({token:data['accessToken'],},() => {console.log(this.state.token)})
   )
   .catch(error => console.log(error));  
}

 
  render() {


    return (
      
      <div className=" login-container">
        <center>
            <div className="login-container2">
                <div className="login-form">
                  <div className="login-form-1">
                    <h3 >Login</h3>
                    <div>
                        <div className="form-group">
                            <input type="text" className="form-control" onChange={this.changeEmailOrUsername} placeholder="Your Email *"  />
                        </div>
                        <div className="form-group">
                            <input type="text" className="form-control" onChange={this.changePassword} placeholder="Your Password *"  />
                        </div>
                        <div className="form-group">
                            <input type="submit" className="btnSubmit" value="Login" onClick={this.login} />
                        </div>
                        </div>
                    </div>
                </div>
            </div>
            </center>
        </div>
    )
  }
}


