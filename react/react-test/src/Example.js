import React from 'react';

class Example extends React.Component {
    constructor(props) {
        super(props);
        this.state = {date: new Date()};
    }

    componentDidMount() {
        this.timerID1 = setInterval(
            () => this.tick(),
            1000
        );
    }
     
    componentWillUnmount() {
        clearInterval(this.timerID1);
    }
    
    tick() {
        this.setState({
            date: new Date()
        });
    }

    render() {
        return (
            <div>
                <h1>Hello, {this.props.name}!</h1>
                <h2> time now: {this.state.date.toLocaleTimeString()} </h2>
            </div>
        );
    }
  }
  
  export default Example;