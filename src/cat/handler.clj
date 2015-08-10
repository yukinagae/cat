(ns cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as response]
            [cat.engine.simple :as simple]
            [cat.engine.google :as google]
            [cat.engine.linus :as linus]))

(defroutes app-routes
  (GET "/" [] (response/redirect "index.html"))
  (GET "/call/request" request (str request)) ;; debug
  (GET "/call/" [] "zzz")
  (GET "/call/google" request (google/response (get (:headers request) "accept-language")))
  (GET "/call/linus" [] (linus/response))
  (GET "/call/:call" [call] (simple/response))
  (route/not-found "mew"))

(def app
  (wrap-defaults app-routes site-defaults))

