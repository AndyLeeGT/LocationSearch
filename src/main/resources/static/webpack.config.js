const path = require('path');
const HotModuleReplacementPlugin = require('react-hot-loader');

module.exports = {
    mode: 'development',
    // entry: './src/lib/index.js',
    entry: ['react-hot-loader/patch', './src/lib/index.js'],
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
    resolve: {
        extensions: ['*', '.js', '.jsx'],
    },
    // plugins: [
    //     new HtmlWebpackPlugin({
    //       title: 'Output Management',
    //     }),
    //   ],
    // plugins: [HotModuleReplacementPlugin()],
    module: {
      rules: [
        {
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            use: ['babel-loader'],
        },
        {
          test: /\.css$/i,
          use: ['style-loader', 'css-loader'],
        },
        {
          test: /\.(png|svg|jpg|jpeg|gif)$/i,
          type: 'asset/resource',
        },
        ]
    }
}