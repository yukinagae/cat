(ns cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn simple [] "meow")

(defroutes app-routes
  (GET "/" [] "zzz")
  (GET "/:call" [call] (simple))
  (route/not-found "mew"))

(def app
  (wrap-defaults app-routes site-defaults))
