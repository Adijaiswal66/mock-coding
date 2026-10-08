const path = require("node:path");
const DotenvWebpack = require("dotenv-webpack");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = (env, argv) => {
  const mode = argv.mode || "development";

  return {
    entry: "./src/main.jsx",
    output: {
      path: path.resolve(__dirname, "dist"),
      filename: "assets/[name].[contenthash].js",
      clean: true,
      publicPath: "/",
    },
    devtool: mode === "development" ? "eval-source-map" : "source-map",
    resolve: {
      extensions: [".js", ".jsx"],
    },
    module: {
      rules: [
        {
          test: /\.(js|jsx)$/,
          exclude: /node_modules/,
          use: "babel-loader",
        },
      ],
    },
    plugins: [
      new DotenvWebpack({
        path: path.resolve(__dirname, `.env.${mode}`),
        safe: false,
        systemvars: true,
      }),
      new HtmlWebpackPlugin({
        template: path.resolve(__dirname, "public/index.html"),
      }),
    ],
    devServer: {
      historyApiFallback: true,
      port: 3000,
      open: false,
      hot: true,
    },
  };
};
