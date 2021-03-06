Feature: ui operations
  basic ui operations, like navigation, clicking

  Background:
    * base uri: http://localhost:12306/local

  Scenario: navigate and refresh
    * open: /index.html
    * verify: '#current' text: 'index.html'

    * click: '#users'
    * verify: '#current' text: 'users.html'

    * go back
    * verify: '#current' text: 'index.html'

    * go forward
    * verify: '#current' text: 'users.html'

    * refresh
    * verify: '#current' text: 'users.html'

    * close
