import React from "react";

/**
 * 按需异步加载组件
 * @param {*} getComponent 
 * @returns 
 */
export default function asyncComponent(getComponent) {
    return class AsyncComponent extends React.Component {
    constructor(props) {
      super(props);

      this.state = {
        component: null
      };
    }

    async componentDidMount() {
      const { default: component } = await getComponent();

      this.setState({
        component
      });
    }

    render() {
      const C = this.state.component;
      return C ? <C {...this.props} /> : null;
    }
  }
}
