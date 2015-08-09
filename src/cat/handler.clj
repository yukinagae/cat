(ns cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as response]))

(defn simple [] "meow")

(defroutes app-routes
  (GET "/" [] (response/redirect "index.html"))
  (GET "/call/" [] "zzz")
  (GET "/call/:call" [call] (simple))
  (route/not-found "mew"))

(def app
  (wrap-defaults app-routes site-defaults))
