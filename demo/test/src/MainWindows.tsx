import * as React from 'react';
import  * as Search from 'antd/lib/input/Search';
// import './MainWindows.css';
// import 'antd/lib/input/style/css';

class MainWindows extends React.Component {
  public render() {
    return (
      <div style={{ margin: 100 }}>
      <h1>AntDesign Demo</h1>
      <hr /><br />
      <Search
          placeholder="input search text"
          enterButton="Search"
          size="large"
        />
      </div>
    );
  }
}

export default MainWindows;