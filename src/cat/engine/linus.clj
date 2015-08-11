(ns cat.engine.linus
  (:require [net.cgrand.enlive-html :as html]))

;; TODO this is buggy. should avoid "External Links"
(defn quotes []
  (-> (java.net.URL. "https://en.wikiquote.org/wiki/Linus_Torvalds") 
    html/html-resource 
    (html/select [:div#mw-content-text :> :ul :> :li]))) 

;; TODO 0 should be random depends on quotes size
(defn get-quote [quotes]
  (-> (nth quotes 0) :content first))

;; "Talk is cheap. Show me the code. ― Linus Torvalds"
(defn response [] (-> (quotes) get-quote))
