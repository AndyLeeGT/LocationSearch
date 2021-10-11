"use strict";

var _root = require("react-hot-loader/root");

var _axios = _interopRequireDefault(require("axios"));

var _react = _interopRequireDefault(require("react"));

var _reactDom = _interopRequireDefault(require("react-dom"));

var _LoginScreen = _interopRequireDefault(require("./components/LoginScreen"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { "default": obj }; }

var title = 'React with Webpack and Babel';

_reactDom["default"].render( /*#__PURE__*/_react["default"].createElement(_LoginScreen["default"], null), document.getElementById("app"));