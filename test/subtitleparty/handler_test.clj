(ns subtitleparty.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [subtitleparty.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "<body><form action=\"http://localhost:3000/upload\" method=\"post\" enctype=\"multipart/form-data\"><input type=\"file\" name=\"file\"></input><input type=\"submit\"></input></form></body>"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
