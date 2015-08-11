(ns cat.engine.chat
  (:import (com.google.code.chatterbotapi ChatterBotFactory ChatterBotType)))

(def bot (-> (.create (ChatterBotFactory.) ChatterBotType/CLEVERBOT)
             .createSession))

(defn response [call] (.think bot call))
