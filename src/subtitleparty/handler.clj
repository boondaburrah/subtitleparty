(ns subtitleparty.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn handle-file [file]
  (println (get file :filename)))

(defroutes app-routes
  (GET "/" [] "<body><form action=\"http://localhost:3000/upload\" method=\"post\" enctype=\"multipart/form-data\"><input type=\"file\" name=\"file\"></input><input type=\"submit\"></input></form></body>")
  (POST "/upload" {{{tempfile :tempfile filename :filename} :file} :params :as params}
    (io/copy tempfile (io/file "resources" "public" filename)) "file!")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))

