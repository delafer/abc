const path = require('path');
const webpack = require('webpack');
const ClosurePlugin = require('closure-webpack-plugin');

const ROOT = path.resolve( __dirname, 'src' );
const DESTINATION = path.resolve( __dirname, 'dist' );

module.exports = {
    context: ROOT,

    entry: {
        'main': './main.ts'
    },

    optimization: {
        minimize: true,
        removeEmptyChunks: true,
        mangleWasmImports: true,
        mergeDuplicateChunks: true,
        // innerGraph: true,
        // mangleExports: true,
        concatenateModules: false,
        // minimizer: [
        //     new ClosurePlugin({platform: 'javascript', mode: 'AGGRESSIVE_BUNDLE'}, {
        //         // compiler flags here
        //         //
        //         // for debugging help, try these:
        //         //
        //         // formatting: 'PRETTY_PRINT'
        //         // debug: true,
        //         // renaming: false
        //         dependency_mode: 'PRUNE'
        //     })
        // ]
    },
    
    output: {
        filename: '[name].bundle.js',
        path: DESTINATION
    },

    resolve: {
        extensions: ['.ts', '.tsx', '.js'],
        modules: [
            ROOT,
            'node_modules'
        ]
    },

    module: {
        rules: [
            /****************
            * PRE-LOADERS
            *****************/
            {
                enforce: 'pre',
                test: /\.js$/,
                use: 'source-map-loader'
            },
            {
                enforce: 'pre',
                test: /\.ts$/,
                exclude: /node_modules/,
                use: 'tslint-loader'
            },

            /****************
            * LOADERS
            *****************/
            {
                test: /\.ts$/,
                exclude: [ /node_modules/ ],
                use: 'ts-loader'
            }
        ]
    },

    devtool: 'cheap-module-source-map',
    devServer: {}
};

