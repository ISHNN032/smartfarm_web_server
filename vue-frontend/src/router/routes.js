import DashboardLayout from "@/layout/dashboard/DashboardLayout.vue";
// GeneralViews
import NotFound from "@/pages/NotFoundPage.vue";

// Admin pages
import Dashboard from "@/pages/Main.vue";
import UserProfile from "@/pages/UserProfile.vue";
import Typography from "@/pages/Typography.vue";
import TableList from "@/pages/TableList.vue";
import Icons from "@/pages/Controller.vue";
import Maps from "@/pages/Camera.vue";
import Notifications from "@/pages/Settings.vue";

const routes = [
  {
    path: "/",
    component: DashboardLayout,
    redirect: "/dashboard",
    children: [
      {
        path: "dashboard",
        name: "main",
        component: Dashboard
      },
      {
        path: "stats",
        name: "admin",
        component: UserProfile
      },
      {
        path: "stores",
        name: "dashboard",
        component: TableList
      },
      {
        path: "typography",
        name: "data",
        component: Typography
      },
      {
        path: "icons",
        name: "controller",
        component: Icons
      },
      {
        path: "maps",
        name: "camera",
        component: Maps
      },
      {
        path: "notifications",
        name: "setting",
        component: Notifications
      }
    ]
  },
  { path: "*", component: NotFound }
];

/**
 * Asynchronously load view (Webpack Lazy loading compatible)
 * The specified component must be inside the Views folder
 * @param  {string} name  the filename (basename) of the view to load.
function view(name) {
   var res= require('../components/Dashboard/Views/' + name + '.vue');
   return res;
};**/

export default routes;
