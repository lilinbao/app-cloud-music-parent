//
//  ViewController.m
//  iOSCloudMusicApp
//
//  Created by hcc on 16/8/28.
//
//

#import "MainViewController.h"
#import "AFNetworking.h"

@interface MainViewController ()

@end

@implementation MainViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    NSURLSessionConfiguration* configuration = [NSURLSessionConfiguration defaultSessionConfiguration];
    AFURLSessionManager* manager = [[AFURLSessionManager alloc] initWithSessionConfiguration:configuration];
    NSURL* url = [NSURL URLWithString:@"http://httpbin.org/get"];
    NSURLRequest* request = [NSURLRequest requestWithURL:url];
    NSURLSessionDataTask* dataTask = [manager dataTaskWithRequest:request completionHandler:^(NSURLResponse* response, id responseObject, NSError* error){
        if(error){
            NSLog(@"Error %@", error);
        }else{
            NSLog(@"response data are %@", responseObject);
        }
        
    }];
    [dataTask resume];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
