import asyncComponent from "./asyncComponent";

/**
 * 路由配置
 */
const routers = [
    {
        path: "/dic",
        component: asyncComponent(() => import("./pages/dic"))
    }
];

export default routers;