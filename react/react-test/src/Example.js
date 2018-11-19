import React from 'react';

class FormattedDate extends React.Component{
    constructor(props) {
        super(props);
        this.state = {date : props.date};
    }

    render() {
        return <h2>time now: {this.props.date.toLocaleTimeString()}.</h2>;
    }
}

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
                <FormattedDate date={this.state.date} />
            </div>
        );
    }
  }
  
  export default Example;