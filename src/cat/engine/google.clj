(ns cat.engine.google)

(defn response [lang]
  (if (.contains lang "ja")
    "www.google.co.jp"
    "www.google.com"))
