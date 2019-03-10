//
//  main.m
//  clipboard-test
//
//  Created by Maiken on 10/03/2019.
//  Copyright © 2019 hello_chenchen. All rights reserved.
//

#import <Foundation/Foundation.h>
#include <AppKit/AppKit.h>
#include <AppKit/NSPasteboard.h>

int func(){
    NSPasteboard* pasteboard = [NSPasteboard generalPasteboard];
    
    for(int i = 0; i < pasteboard.types.count; i++) {
        NSLog(@"text: %@", pasteboard.types[i]);
    }
    
    NSArray *classes = [[NSArray alloc] initWithObjects:[NSString class], nil];
    NSDictionary *options = [NSDictionary dictionary];
    NSArray *copiedItems = [pasteboard readObjectsForClasses:classes options:options];
    if (copiedItems != nil) {
        for(int i = 0; i < copiedItems.count; i++) {
            NSString *myStr = copiedItems[0];
            NSLog(@"text: %@", myStr);
            NSLog(@"text: %li", myStr.hash);
        }
    }
    
    return 0;
}

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
        func();
        NSLog(@"Hello, World!");
    }
    return 0;
}
