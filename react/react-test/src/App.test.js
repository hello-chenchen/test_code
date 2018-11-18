import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<App />, div);
  const element = <h1>Hello, world!</h1>;
  ReactDOM.render(
      element,
      document.getElementById('example')
  );
  ReactDOM.unmountComponentAtNode(div);
});
